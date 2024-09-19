class Solution {
    public String simplifyPath(String path) {
          path = path.replaceAll("/+", "/");
          path = path.replaceFirst("/","");
          String[] directories = path.split("/");
          StringBuffer op =new StringBuffer();
          Stack<String> stack = new Stack<>();
          for(String p : directories){
            if(p.equals(".")){}
            else if(p.equals("..")){
                if(!stack.isEmpty())
                   stack.pop();
            }else{
                stack.push(p);
            }
          }
          for(String p : stack){
             op.append(p+"/");
          }
          if(!op.isEmpty()){
              op.replace(op.length()-1, +op.length(), "");
          }
          else return "/";
          return "/"+op.toString();


    }
}