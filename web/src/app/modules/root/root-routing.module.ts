import { RouterModule, Routes } from "@angular/router";
import { NgModule } from "@angular/core";
import { LayoutComponent } from "./layout/layout.component";


export const routes: Routes = [
    {
        path: "", component: LayoutComponent, children: [
            {path: "errors", loadChildren: () => import("../errors/errors.module").then(m => m.ErrorsModule)},
            {path: "users", loadChildren: () => import("../users/users.module").then(m => m.UsersModule)},
        ]
    },
    {path: "**", redirectTo: "/404"}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class RootRoutingModule {

}
