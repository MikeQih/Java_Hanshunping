public class BufferedReader_ {
    private Reader_ reader_;
    public BufferedReader_(Reader_ reader_){
        this.reader_ = reader_;
    }

    //让方法更加灵活，多次读取文件
    public void readFiles(int num){
        for(int i=0;i<num;i++){
            reader_.readFile();
        }
    }
    // public void readFiles(){
    //     reader_.readFile();
    // }

    //扩展 readString，批量处理字符串数据
    public void readString(int num){
        for(int i=0;i<num;i++){
            reader_.readString();
        }
    }
}
//做成处理流/包装流
