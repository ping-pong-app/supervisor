import { BrowserModule } from "@angular/platform-browser";
import { APP_INITIALIZER, NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { AppConfigFactory } from "./factories";
import { KeycloakService } from "@procempa/ngx-keycloak";
import { RootModule } from "./modules/root/root.module";

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        RootModule
    ],
    providers: [
        {provide: APP_INITIALIZER, multi: true, useFactory: AppConfigFactory, deps: [KeycloakService]}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
