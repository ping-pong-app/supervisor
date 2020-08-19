import { Component, OnDestroy, OnInit } from "@angular/core";
import { menuItems } from "../../../../config/menu-items";
import { AuthUser, KeycloakService } from "@procempa/ngx-keycloak";
import { Observable, Subject } from "rxjs";
import { takeUntil } from "rxjs/operators";
import { Meta } from "@angular/platform-browser";

@Component({
    selector: "app-header",
    templateUrl: "./header.component.html",
    styleUrls: ["./header.component.scss"]
})
export class HeaderComponent implements OnInit, OnDestroy {

    public navbarOpened = false;
    public menuItems = menuItems;
    public user$: Observable<AuthUser>;
    public destroy$: Subject<boolean> = new Subject<boolean>();

    constructor(private keycloakService: KeycloakService) {

    }

    ngOnInit(): void {
        this.user$ = this.keycloakService.getUser().pipe(
            takeUntil(this.destroy$)
        );

    }

    public toggleNavbar(): void {
        this.navbarOpened = !this.navbarOpened;
    }

    public logout(): void {

    }

    public login(): void {

    }

    public ngOnDestroy(): void {
        this.destroy$.next(true);
    }

}
