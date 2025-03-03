public class SpikeLayout {
    int  SpikeX, SpikeY, SpikeHeight, SpikeWidth, spikeSpeed;
    PlayerLayout user1;

    public SpikeLayout(int spikeX, int spikeY, int spikeW, int spikeH, int spikeSpeed, PlayerLayout user1) {
        this.SpikeX = spikeX;
        this.SpikeY = spikeY;
        this.SpikeWidth = spikeW;
        this.SpikeHeight = spikeH;
        this.spikeSpeed= spikeSpeed;
        this.user1= user1;
    }

    public boolean spikeBoundary () {
        if (user1.UserY + user1.UserHeight >= SpikeY && user1.UserY <= SpikeY + SpikeHeight) {
            if (user1.UserX + user1.UserWidth >= SpikeX && user1.UserX <= SpikeX + SpikeWidth) {
                return true;
            }
        }
        return false;
    }

    public void SpikeCollision(){
        if(spikeBoundary()){
            whenUserTouchesObstacle();
        }
    }

    public void whenUserTouchesObstacle() {
        user1.lives--;

    }

    public void spikeMovement(){
        SpikeX = SpikeX +spikeSpeed;
    }

    public void spikeActions(){
        SpikeCollision();
        spikeMovement();
    }
}
