import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { UsersRoutingModule } from "./users-routing.module";
import { UsersOverviewPageComponent } from "./pages/users-overview-page/users-overview-page.component";

@NgModule({
    imports: [
        CommonModule,
        UsersRoutingModule,
    ],
    exports: [],
    declarations: [
        UsersOverviewPageComponent,
    ]
})
export class UsersModule {

}
