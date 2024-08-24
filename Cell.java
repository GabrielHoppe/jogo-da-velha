public class Cell {

    int time;
    boolean hasPlayer;
    int posx;
    int posy;
    String playerType;

    public Cell(int posx, int posy){
        this.posx = posx;
        this.posy = posy;

        playerType = " ";

        time = 7;
        hasPlayer = false;

    }

    public String toString(){
        if (hasPlayer){

            if (time <= 1){
                return "|"+playerType.toUpperCase()+"|";
            }

            return "|"+playerType+"|";
        }

        return "| |";
    }

    public void timePassed(){
        if (hasPlayer == false){
            return;
        }
        time --;
        if (time <= 0){
            hasPlayer = false;
            playerType = " ";
        }
    }

    public void setHasPlayer(boolean hasPlayer, String playerType){
        this.hasPlayer = hasPlayer;
        if (hasPlayer == true){
            time = 7;
            this.playerType = playerType;
        }
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public boolean getHasPlayer(){
        return hasPlayer;
    }

    public String getPlayer(){
        return playerType;
    }
}
