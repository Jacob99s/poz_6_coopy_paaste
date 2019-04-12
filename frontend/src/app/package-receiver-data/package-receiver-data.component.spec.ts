import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageReceiverDataComponent } from './package-receiver-data.component';

describe('PackageReceiverDataComponent', () => {
  let component: PackageReceiverDataComponent;
  let fixture: ComponentFixture<PackageReceiverDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackageReceiverDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageReceiverDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
