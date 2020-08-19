import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorsOverviewPageComponent } from './errors-overview-page.component';

describe('ErrorsOverviewPageComponent', () => {
  let component: ErrorsOverviewPageComponent;
  let fixture: ComponentFixture<ErrorsOverviewPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ErrorsOverviewPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ErrorsOverviewPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
