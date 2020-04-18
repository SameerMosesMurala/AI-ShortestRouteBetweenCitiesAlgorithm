import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class lists implements Comparable<lists>
{
String city;
int cost;
@Override
   public int compareTo(lists o){
         int comparedSize=o.cost; 
		 if(this.cost>comparedSize){
		 return 1;
		 }else if (this.cost==comparedSize){
		 return 0;
		 } else{
		 return -1;
		 }
   }
   }
class closedlists implements Comparable<closedlists>
{
String city;
int cost;
@Override
   public int compareTo(closedlists o){
         int comparedSize=o.cost; 
		 if(this.cost>comparedSize){
		 return 1;
		 }else if (this.cost==comparedSize){
		 return 0;
		 } else{
		 return -1;
		 }
   }
   }
 class data
 {
 String source;
 String destination;
 int distance;
 }
 class find_route
 {
 public static void main(String[] args)
 {
 try
 {
int i=0;
int i2=0;
int bit=0;
String descion="";
String sourcecity="";
String destinationcity="";
String filename="";
String filename2="";
//String filename2="";
//if(args.length>3)
//{
//if(descion.equals("inf"))
//{
//bit=1;
//filename2=args[3];
//}
//}

       // int  array_length = args.length;

        // for(int i7=0;i7<array_length;i7++){
            // switch(i)
		// {
   
   // case 0:   
      // descion = args[i7];
      // break;   
   // case 1: 
      // filename = args[i7];
      // break;
   // case 2:
     // sourcecity = args[i7];
     // break;
   // case 3:
     // destinationcity = args[i7];
     // break;
   // case 4:
     // filename2 = args[i7];
     // break;
      // }

        // }


/*int arraylenth=args.length;
for(int t=0;t<(arraylenth);)
{
==args[t];
t=t+1;
filename=args[t];
t=t+1;
sourcecity=args[t];
t=t+1;
destinationcity=args[t];
t=t+1;
filename2=args[t];
}*/
if(descion.equals("inf"))
{
bit=1;
}
int hueristic=0;
String firstcity;
//String sourcecity="Munich";
//String destinationcity="Kassel";
//String filename="C:/Users/Sameer/Desktop/input1.txt";
//String filename2="C:/Users/Sameer/Desktop/h_kassel.txt";
FileReader fileReader2=new FileReader(filename2);
//Scanner fileReader2=new Scanner(filename2);
BufferedReader reader2=new BufferedReader(fileReader2);
FileReader fileReader=new FileReader(filename);
//Scanner fileReader=new Scanner(filename);
BufferedReader reader=new BufferedReader(fileReader);
LinkedList<lists> citylist=new LinkedList<lists>();
LinkedList<closedlists> closedcitylist=new LinkedList<closedlists>();
LinkedList<String> closedcitylist1=new LinkedList<String>();
data[] dataar=new data[1000];
data[] dataar2=new data[1000];
for(int j=0;j<100;j++)
{
dataar[i]=new data();
dataar2[i]=new data();
}
String line=null;
while((line=reader.readLine())!=null)
{
if(line.equals("END OF INPUT"))
{
break;
}
String[] array1=line.split(" ");
dataar[i]=new data();
dataar[i].source=array1[0];
dataar[i].destination=array1[1];
dataar[i].distance=Integer.parseInt(array1[2]);
i=i+1;
dataar[i]=new data();
dataar[i].source=array1[1];
dataar[i].destination=array1[0];
dataar[i].distance=Integer.parseInt(array1[2]);
i=i+1;
}
String line2=null;
while((line2=reader.readLine())!=null)
{
if(line2.equals("END OF INPUT"))
{
break;
}
String[] array12=line.split(" ");
dataar2[i]=new data();
dataar2[i].source=array12[0];
dataar2[i].distance=Integer.parseInt(array12[1]);
i2=i2+1;
}
lists sl1=new lists();
sl1.city=sourcecity;
sl1.cost=0;
lists firstcityob=new lists();
int fc=0;
closedlists[] firstclosedcityob=new closedlists[1000];
lists[] listar=new lists[1000];
citylist.add(sl1);
int g=0;
int sci3=0;
int totaldistance=0;
while(citylist.isEmpty()==false)
{
firstclosedcityob[fc]=new closedlists();
firstcityob=citylist.pollFirst();
firstcity=firstcityob.city;
firstclosedcityob[fc].city=firstcityob.city;
firstclosedcityob[fc].cost=firstcityob.cost;
if(firstcity.equals(destinationcity))
{
int sci2=0;
int dci=0;
int bt=0;
int sci=0;
data[] dc=new data[10000];
data[] storedcity=new data[10000];
data[] storedcitylist=new data[10000];
String lsourcecity="xxxx";
String ldestinationcity=destinationcity;
//System.out.println("Destination is Reached");
while(lsourcecity.equals(sourcecity)==false)
{
dci=0;
sci2=0;
bt=0;
for(int b=0;b<i;b++)
{
if((dataar[b].destination).equals(ldestinationcity))
{
storedcitylist[dci]=new data();
storedcitylist[dci].source=dataar[b].source;
storedcitylist[dci].destination=dataar[b].destination;
storedcitylist[dci].distance=dataar[b].distance;
dci=dci+1;
bt=bt+1;
}
}
int b2=0;
while(b2<closedcitylist.size() && closedcitylist.size()>0)
{
closedlists printcitys=new closedlists();
Collections.sort(closedcitylist);
printcitys=closedcitylist.get(b2);
if(sci2==1)
{
break;
}
 for(int b1=0;b1<bt;b1++)
 {
 if((printcitys.city).equals(storedcitylist[b1].source))
{
storedcity[sci]=new data();
storedcity[sci].source=storedcitylist[b1].source;
storedcity[sci].destination=storedcitylist[b1].destination;
storedcity[sci].distance=storedcitylist[b1].distance;
totaldistance=totaldistance+storedcity[sci].distance;
closedcitylist.remove(b2);
sci3=sci;
sci=sci+1;
sci2=1;
break;
}
}
b2=b2+1;
}
lsourcecity=storedcity[sci3].source;
ldestinationcity=storedcity[sci3].source;
}
System.out.println("distance"+totaldistance);
for(int pt=0;pt<sci;pt++)
{
System.out.println(storedcity[pt].source+"to"+storedcity[pt].destination+","+storedcity[pt].distance);
//System.out.println(storedcity[pt].destination);
//System.out.println(storedcity[pt].distance);
//System.out.println(sci);
}
break;
}
else
{
int skip=0;
for(int k=0;k<closedcitylist1.size();k++)
{
if((firstcity.equals(closedcitylist1.get(k))))
{
skip=1;
}
}
if(skip!=1)
{
if(bit==0)
{
for(int c=0;c<i;c++)
{
if(dataar[c].source.equals(firstcity))
{
listar[g]=new lists();
listar[g].city=dataar[c].destination;
listar[g].cost=dataar[c].distance+firstcityob.cost;
citylist.add(listar[g]);
g=g+1;
}
}
}
else
{
for(int jk=0;jk<i2;jk++)
{
if(dataar2[jk].source.equals(firstcity))
{
hueristic=dataar2[jk].distance;
}
}
for(int c=0;c<i;c++)
{
if(dataar[c].source.equals(firstcity))
{
listar[g]=new lists();
listar[g].city=dataar[c].destination;
listar[g].cost=dataar[c].distance+firstcityob.cost+hueristic;
citylist.add(listar[g]);
g=g+1;
}
}
}
Collections.sort(citylist);
int skip1=0;
for(int k1=0;k1<closedcitylist1.size();k1++)
{
if((firstcity.equals(closedcitylist1.get(k1))))
{
skip=1;
}
}
if(skip1!=1)
{
closedcitylist.addLast(firstclosedcityob[fc]);
String addcity;
addcity=firstclosedcityob[fc].city;
closedcitylist1.add(addcity);
}
}
fc=fc+1;
}
}
if(citylist.isEmpty())
{
System.out.println("distance:infinity");
System.out.println("route:");
System.out.println("none");
}
reader.close();
}
catch(FileNotFoundException ex)
{
System.out.println("File NOt found1");
}
catch(IOException ex)
{
System.out.println("IO Exception");
}
}
}















