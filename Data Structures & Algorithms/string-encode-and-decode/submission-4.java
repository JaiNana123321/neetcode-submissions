class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }
        List<Integer> sizes = new ArrayList<>(strs.size());
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sizes.add(s.length());
            sb.append("" + s.length());
            sb.append(",");
        }
        sb.setCharAt(sb.length()-1,'#');

        for(String s: strs){
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();

        int delimIndex = str.indexOf('#');
        String lengths = str.substring(0,delimIndex);
        String[] lengthsStr = lengths.split(",");
        String words = str.substring(delimIndex+1,str.length());
        
        int offset = 0;
        for(String s : lengthsStr){
            int size = Integer.parseInt(s);
            if(size == 0){
                result.add("");
            }else{
                result.add(words.substring(offset, offset+size));
                offset += size;
            }
        }

        return result;
    }
}
