import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersOverviewPageComponent } from './users-overview-page.component';

describe('UsersOverviewComponent', () => {
  let component: UsersOverviewPageComponent;
  let fixture: ComponentFixture<UsersOverviewPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersOverviewPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersOverviewPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
