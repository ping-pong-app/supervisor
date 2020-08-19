import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgxKeycloakModule } from "@procempa/ngx-keycloak";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RootRoutingModule } from "./root-routing.module";
import { RouterModule } from "@angular/router";
import { LayoutComponent } from "./layout/layout.component";
import { HeaderComponent } from "./components/header/header.component";
import { HeaderLinkComponent } from "./components/header/header-link/header-link.component";
import { SharedModule } from "../shared/shared.module";


@NgModule({
    declarations: [
        LayoutComponent,
        HeaderComponent,
        HeaderLinkComponent,
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        NgxKeycloakModule.forRoot(),
        FormsModule,
        ReactiveFormsModule,
        RootRoutingModule,
        SharedModule
    ],
    exports: [
        RouterModule
    ]
})
export class RootModule {

}
