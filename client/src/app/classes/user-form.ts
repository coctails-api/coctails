export class UserForm {
  password: string;
  email: string;

  constructor(email: string = '', password: string = '') {
    this.password = password;
    this.email = email;
  }
}
