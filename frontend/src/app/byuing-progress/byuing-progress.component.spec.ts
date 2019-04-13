import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ByuingProgressComponent } from './byuing-progress.component';

describe('ByuingProgressComponent', () => {
  let component: ByuingProgressComponent;
  let fixture: ComponentFixture<ByuingProgressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ByuingProgressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ByuingProgressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
