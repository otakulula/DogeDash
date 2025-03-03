public class PortalLayout {
    int portalX, portalY, portalW, portalH, portalSpeed;

    public PortalLayout ( int portalX, int portalY, int portalW, int portalH, int portalSpeed){
        this.portalX = portalX;
        this.portalY = portalY;
        this.portalW= portalW;
        this.portalH = portalH;
        this.portalSpeed = portalSpeed;
    }

    public void portalMovement(){
        portalX = portalX + portalSpeed;
    }

}
