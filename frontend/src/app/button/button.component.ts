import { Component, OnInit } from '@angular/core';
import {Button} from './button';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  button: Button = {
    label: 'PRZEJDŹ DO PODSUMOWANIA'
  };

  ngOnInit(): void {
  }
}
