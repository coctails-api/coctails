import {
  Directive,
  ElementRef,
  HostBinding,
  HostListener,
} from '@angular/core';

@Directive({
  selector: '[appFadeBackground]',
})
export class FadeBackgroundDirective {
  @HostBinding('style.opacity') opacity: string;

  @HostListener('window:scroll', [])
  onWindowScroll() {
    const elementPosition = this.el.nativeElement.getBoundingClientRect().top;
    const screenHeight = window.innerHeight;
    this.opacity = (1 - elementPosition / screenHeight).toString();
  }

  constructor(private el: ElementRef) {
    this.opacity = '100';
  }
}
