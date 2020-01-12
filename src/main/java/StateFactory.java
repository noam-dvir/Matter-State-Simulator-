public class StateFactory {

    public State getState(String stateString){
        if(stateString == null){
            return null;
        }
        if(stateString.equalsIgnoreCase("G")){
            return new Gas();

        } else if(stateString.equalsIgnoreCase("S")){
            return new Solid();

        } else if(stateString.equalsIgnoreCase("L")){
            return new Liquid();

        } else if(stateString.equalsIgnoreCase("P")){
            return new Plasma();

        } else if(stateString.equalsIgnoreCase("X")){
            return new X();
        }

        return null;
    }
}
