public class FileLines {

    String id, cluster, version, user, app, market;

    public FileLines(String id, String cluster, String version, String user, String app, String market) {
        this.id = id;
        this.cluster = cluster;
        this.version = version;
        this.user = user;
        this.app = app;
        this.market = market;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return this.id + "      " +
                this.cluster + "      " +
                this.version + "      " +
                this.user + "      " +
                this.app + "      " +
                this.market + "\n";
    }
}
