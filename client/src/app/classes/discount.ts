export class Discount {
  id: number = 0;
  name: string;
  discount: bigint;

  constructor(name: string, discount: bigint) {
    this.name = name;
    this.discount = discount;
  }
}
