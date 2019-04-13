import {Component, OnInit} from '@angular/core';
import {Payment} from './payment';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent implements OnInit {

  payment: Payment = {
    price: 10,
    prepayPrice: 20
  };

  constructor() {
  }

  ngOnInit() {
  }

}
