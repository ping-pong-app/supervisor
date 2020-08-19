import { KeycloakService } from "@procempa/ngx-keycloak";
import { ConfigService } from "@mjamsek/ngx-config";
import { environment } from "../environments/environment";
import { AppEnv } from "../environments/env.models";

export function AppConfigFactory(keycloakService: KeycloakService): () => Promise<void> {
    return async () => {
        await ConfigService.initialize<AppEnv>({path: "http://localhost:8080/v1/web-config", environment});

        const keycloakConfig = {
            url: ConfigService.getConfig<AppEnv>().keycloak.url,
            realm: ConfigService.getConfig<AppEnv>().keycloak.realm,
            clientId: ConfigService.getConfig<AppEnv>().keycloak.clientId
        };
        await keycloakService.init(keycloakConfig, {onLoad: "login-required"});
    };
}
