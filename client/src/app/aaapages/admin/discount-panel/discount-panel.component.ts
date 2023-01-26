import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";
import {Discount} from "../../../classes/discount";
import {DiscountService} from "../../../service/discount.service";

@Component({
  selector: 'app-discount-panel',
  templateUrl: './discount-panel.component.html',
  styleUrls: ['./discount-panel.component.css']
})
export class DiscountPanelComponent implements OnInit {
  formGroup: FormGroup;
  conflict = "";
  submitted = false;
  public discountList: Discount[] = [];

  constructor(private discountService: DiscountService) {
    this.formGroup = new FormGroup({
      name: new FormControl('',[
        Validators.pattern(/^[a-zA-Z0-9]*$/)
      ]),
      discount: new FormControl('',[
        Validators.pattern(/^[0-9]*$/)
      ])
    });
  }

  ngOnInit(): void {
    this.getDiscounts();
  }

  public changeSubmit():void{
    this.submitted = true;
  }

  public addDiscount(): void{
    this.changeSubmit();
    const name = this.formGroup.get('name')?.value;
    const discounts = this.formGroup.get('discount')?.value;
    if(this.formGroup.invalid)
      return;

    let discount = new Discount(name, discounts);

    this.discountService.addDiscount(discount).subscribe((response: any) => {
      this.formGroup.reset();
      this.getDiscounts();
    }, (error: HttpErrorResponse) => {
      {{error.status == 409 ? this.conflict = "Email już istnieje" : this.conflict = ""}}
    });
  }

  public deleteDiscount(id?: number): void{
    if(id){
    this.discountService.deleteDiscount(id).subscribe((response: void) => {
      this.getDiscounts();
    },(error: HttpErrorResponse) => {
      alert("blad przy usuwaniu")
    })
    }
  }

  public getDiscounts(): void {
    this.discountService.getDiscounts().subscribe((response: Discount[]) => {
        this.discountList = response;
      }, (error: HttpErrorResponse) => {
        alert("blad")
      }
    )
  }
}
