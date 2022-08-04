import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RsocialesComponent } from './rsociales.component';

describe('RsocialesComponent', () => {
  let component: RsocialesComponent;
  let fixture: ComponentFixture<RsocialesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RsocialesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RsocialesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
