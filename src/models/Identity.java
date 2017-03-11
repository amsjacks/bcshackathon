package models;

/**
 * An enum for the marginalized identities tracked by the app.
 *
 * Created by aislin on 2017-03-11.
 */
public enum Identity {
    WOMAN("Woman"),
    LGBTQ("LGBTQ+"),
    TRANS("Trans *"),
    POC("Person of Colour"),
    ASIAN("East Asian"),
    S_ASIAN("South Asian"),
    BLACK("Black"),
    FN("Indigenous"),
    LATINX("Latina/Latino"),
    IMMIGRANT("Immigrant"),
    G_SOUTH("From the Global South"),
    REFUGEE("Refugee"),
    RELIGION("Religious Minority"),
    MUSLIM("Muslim");

    private String displayName;
    Identity(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
