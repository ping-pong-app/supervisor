import { Injectable } from "@angular/core";
import { Meta, Title } from "@angular/platform-browser";

@Injectable({
    providedIn: "root"
})
export class Seo {

    constructor(private title: Title, private meta: Meta) {

    }

    public setPageTitle(title: string, prefix?: string): void {
        const newTitle = `${title} | ${prefix || "Supervisor"}`;
        this.title.setTitle(newTitle);
    }

}
