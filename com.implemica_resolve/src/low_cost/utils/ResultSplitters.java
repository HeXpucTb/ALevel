package low_cost.utils;

public abstract class ResultSplitters {
    public static int[] getIntValuesFromLine(String line){
        int[] intValues = new int[2];
        int spaceIndex = line.indexOf(" ");
        String firstPart = line.substring(0,spaceIndex);
        String secondPart = line.substring(spaceIndex+1);
        try{
            intValues[0] = Integer.parseInt(firstPart);
            intValues[1] = Integer.parseInt(secondPart);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return intValues;
    }
    public static String[] getStringValuesFromLine(String line){
        String[] stringValues = new String[2];
        int spaceIndex = line.indexOf(" ");
        stringValues[0] = line.substring(0,spaceIndex);
        stringValues[1] = line.substring(spaceIndex+1);
        return stringValues;
    }
}
