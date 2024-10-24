import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IghRoutingModule } from './igh-routing.module';
import { EmployeeComponent } from './pages/employee/employee.component';
import { HrComponent } from './pages/hr/hr.component';
import { ManagerComponent } from './pages/manager/manager.component';
import { AdminComponent } from './pages/admin/admin.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HrRequestFormComponent } from './components/hr-request-form/hr-request-form.component';
import { RequestsTableComponent } from './components/requests-table/requests-table.component';
import { EmployeeBookingsComponent } from './components/employee-bookings/employee-bookings.component';
import { AddRoomPopupComponent } from './components/add-room-popup/add-room-popup.component';
import { ConfirmPopupComponent } from './components/confirm-popup/confirm-popup.component';
import { MainComponent } from './components/main/main.component';
import { PopupFurnitureComponent } from './components/popup-furniture/popup-furniture.component';
import { PopupComponent } from './components/popup/popup.component';
import { RoomComponent } from './components/room/room.component';



@NgModule({
  declarations: [
    EmployeeComponent,
    HrComponent,
    ManagerComponent,
    AdminComponent,
    NavbarComponent,
    FooterComponent,
    HrRequestFormComponent,
    RequestsTableComponent,
    EmployeeBookingsComponent,
    AddRoomPopupComponent,
    ConfirmPopupComponent,
    MainComponent,
    PopupFurnitureComponent,
    PopupComponent,
    RoomComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    IghRoutingModule,
    ReactiveFormsModule
  ]
})
export class IghModule { }
