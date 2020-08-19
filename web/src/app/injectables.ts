import { InjectionToken } from "@angular/core";
import { ConfigService } from "@mjamsek/ngx-config";
import { AppEnv } from "../environments/env.models";

export const API_URL = new InjectionToken<string>("apiUrl", {
    providedIn: "root",
    factory: () => ConfigService.getConfig<AppEnv>().apis.supervisor.url + "/v1"
});
