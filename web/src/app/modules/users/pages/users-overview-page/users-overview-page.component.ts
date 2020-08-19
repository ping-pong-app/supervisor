import { Component, OnInit } from "@angular/core";
import { Seo } from "../../../../services/seo.service";

@Component({
    selector: "app-users-overview",
    templateUrl: "./users-overview-page.component.html",
    styleUrls: ["./users-overview-page.component.scss"]
})
export class UsersOverviewPageComponent implements OnInit {

    constructor(private seo: Seo) {
    }

    ngOnInit(): void {
        this.seo.setPageTitle("Users");
    }

}
