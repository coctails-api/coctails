export class Discount {
  id: number | null;
  name: string;
  discount: bigint;

  constructor(name: string, discount: bigint) {
    this.name = name;
    this.discount = discount;
  }
}
