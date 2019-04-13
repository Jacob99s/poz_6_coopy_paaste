import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplyMethodComponent } from './supply-method.component';

describe('SupplyMethodComponent', () => {
  let component: SupplyMethodComponent;
  let fixture: ComponentFixture<SupplyMethodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SupplyMethodComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplyMethodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

@Component({
  selector: 'app-supply-method',
  templateUrl: `supply-method.component.html`
})

export class supplyMethodComponent {

  public onClickMe() {
    console.log('Hej, I just meet Ju');
  }
}