# LazyLogger
android日志打印库,可以配置打印到本地,打印格式化的日志

**LoggerLibrary** 

LoggerLibrary是一个为android设计的日志打印库,使用方法如下:

# android project 引入此库方式:
    compile 'com.robin.lazy.logger:LoggerLibrary:1.0.0'
 
# 首先要进行初始化,建议只初始化一次,可以在AppLication中进行初始化化操作:
   
       @Override
       public void onCreate() {
           super.onCreate();
           initLogger();
       }
   
       /***
        * 初始化日志系统
        *
        * @throws
        * @see [类、类#方法、类#成员]
        */
       protected void initLogger() {
           LazyLogger.init(/* PrinterType.FORMATTED */PrinterType.ORDINARY) // 打印类型
                   .methodCount(3) // default 2
                   .hideThreadInfo() // default shown
                   .logLevel(LogLevel.ALL) // default LogLevel.ALL(设置全局日志等级)
                   .methodOffset(2) // default 0
                   .logTool(/* new AndroidLogTool() *//*new SLF4JTool()*/new Log4JTool(Level.ERROR)); // Log4j中的Level与本框架的LogLevel是分开设置的(Level只用来设置log4j的日志等级)
       }
 
 **Api说明:**
 **PrinterType为打印日子类型枚举,目前有两种类型:**
   [1]PrinterType.ORDINARY 普通的日志打印类型,打印出来的日志就是一般的日志
       普通日志打印类型的实现类LoggerOrdinaryPrinter.java
   [2]PrinterType.FORMATTED 为格式化的日志打印类型,打印出来的日志如下
       格式化的日子打印实现类LoggerFormattedPrinter.java
 
    04-15 14:19:14.149 9240-9240/com.robin.lazy.sample I/LazyLogger: ╔════════════════════════════════════════════════════════════════════════════════════════
        04-15 14:19:14.150 9240-9240/com.robin.lazy.sample I/LazyLogger: ║ ActivityThread.handleLaunchActivity  (ActivityThread.java:2701)
        04-15 14:19:14.150 9240-9240/com.robin.lazy.sample I/LazyLogger: ║    ActivityThread.performLaunchActivity  (ActivityThread.java:2590)
        04-15 14:19:14.150 9240-9240/com.robin.lazy.sample I/LazyLogger: ║       Instrumentation.callActivityOnCreate  (Instrumentation.java:1125)
        04-15 14:19:14.151 9240-9240/com.robin.lazy.sample I/LazyLogger: ╟────────────────────────────────────────────────────────────────────────────────────────
        04-15 14:19:14.152 9240-9240/com.robin.lazy.sample I/LazyLogger: ║ com.robin.lazy.sample.MainActivity
        04-15 14:19:14.153 9240-9240/com.robin.lazy.sample I/LazyLogger: ╚════════════════════════════════════════════════════════════════════════════════════════
        04-15 14:19:14.155 9240-9240/com.robin.lazy.sample D/LazyLogger: ╔════════════════════════════════════════════════════════════════════════════════════════
        04-15 14:19:14.157 9240-9240/com.robin.lazy.sample D/LazyLogger: ║ ActivityThread.handleLaunchActivity  (ActivityThread.java:2701)
        04-15 14:19:14.158 9240-9240/com.robin.lazy.sample D/LazyLogger: ║    ActivityThread.performLaunchActivity  (ActivityThread.java:2590)
        04-15 14:19:14.159 9240-9240/com.robin.lazy.sample D/LazyLogger: ║       Instrumentation.callActivityOnCreate  (Instrumentation.java:1125)
        04-15 14:19:14.160 9240-9240/com.robin.lazy.sample D/LazyLogger: ╟────────────────────────────────────────────────────────────────────────────────────────
        04-15 14:19:14.161 9240-9240/com.robin.lazy.sample D/LazyLogger: ║ {
        04-15 14:19:14.161 9240-9240/com.robin.lazy.sample D/LazyLogger: ║     "province": [
        04-15 14:19:14.161 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.162 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "100000",
        04-15 14:19:14.162 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "全国"
        04-15 14:19:14.163 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.163 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.164 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "110000",
        04-15 14:19:14.164 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "北京市"
        04-15 14:19:14.165 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.166 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.166 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "120000",
        04-15 14:19:14.166 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "天津市"
        04-15 14:19:14.167 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.167 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.168 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "130000",
        04-15 14:19:14.169 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "河北省"
        04-15 14:19:14.170 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.171 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.171 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "140000",
        04-15 14:19:14.172 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "山西省"
        04-15 14:19:14.173 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.174 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.175 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "150000",
        04-15 14:19:14.176 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "内蒙古自治区"
        04-15 14:19:14.177 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.178 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.178 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "210000",
        04-15 14:19:14.179 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "辽宁省"
        04-15 14:19:14.179 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.179 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.180 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "220000",
        04-15 14:19:14.180 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "吉林省"
        04-15 14:19:14.181 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.181 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.182 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "230000",
        04-15 14:19:14.182 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "黑龙江省"
        04-15 14:19:14.183 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.183 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.184 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "310000",
        04-15 14:19:14.184 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "上海市"
        04-15 14:19:14.185 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.186 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.186 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "320000",
        04-15 14:19:14.187 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "江苏省"
        04-15 14:19:14.188 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.189 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.191 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "330000",
        04-15 14:19:14.192 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "浙江省"
        04-15 14:19:14.193 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.193 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.194 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "340000",
        04-15 14:19:14.194 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "安徽省"
        04-15 14:19:14.195 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.195 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.196 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "350000",
        04-15 14:19:14.196 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "福建省"
        04-15 14:19:14.196 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.197 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.197 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "360000",
        04-15 14:19:14.197 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "江西省"
        04-15 14:19:14.198 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.198 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.199 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "370000",
        04-15 14:19:14.200 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "山东省"
        04-15 14:19:14.200 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.201 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.201 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "410000",
        04-15 14:19:14.201 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "河南省"
        04-15 14:19:14.202 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.202 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.203 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "420000",
        04-15 14:19:14.203 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "湖北省"
        04-15 14:19:14.203 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.204 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.204 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "430000",
        04-15 14:19:14.205 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "湖南省"
        04-15 14:19:14.205 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.205 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.206 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "440000",
        04-15 14:19:14.207 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "广东省"
        04-15 14:19:14.207 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.208 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.208 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "450000",
        04-15 14:19:14.209 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "广西壮族自治区"
        04-15 14:19:14.209 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.210 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.210 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "460000",
        04-15 14:19:14.211 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "海南省"
        04-15 14:19:14.211 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.212 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.212 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "500000",
        04-15 14:19:14.213 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "重庆市"
        04-15 14:19:14.213 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.213 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.214 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "510000",
        04-15 14:19:14.214 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "四川省"
        04-15 14:19:14.215 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.216 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.216 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "520000",
        04-15 14:19:14.217 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "贵州省"
        04-15 14:19:14.217 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.218 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.218 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "530000",
        04-15 14:19:14.219 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "云南省"
        04-15 14:19:14.219 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.220 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.220 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "540000",
        04-15 14:19:14.221 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "西藏自治区"
        04-15 14:19:14.221 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.222 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.222 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "610000",
        04-15 14:19:14.223 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "陕西省"
        04-15 14:19:14.223 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.224 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.224 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "620000",
        04-15 14:19:14.225 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "甘肃省"
        04-15 14:19:14.225 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.225 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.226 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "630000",
        04-15 14:19:14.226 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "青海省"
        04-15 14:19:14.227 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.227 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.227 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "640000",
        04-15 14:19:14.227 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "宁夏回族自治区"
        04-15 14:19:14.228 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         },
        04-15 14:19:14.228 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         {
        04-15 14:19:14.229 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaid": "650000",
        04-15 14:19:14.229 9240-9240/com.robin.lazy.sample D/LazyLogger: ║             "areaname": "新疆维吾尔自治区"
        04-15 14:19:14.229 9240-9240/com.robin.lazy.sample D/LazyLogger: ║         }
        04-15 14:19:14.230 9240-9240/com.robin.lazy.sample D/LazyLogger: ║     ]
        04-15 14:19:14.230 9240-9240/com.robin.lazy.sample D/LazyLogger: ║ }
        04-15 14:19:14.231 9240-9240/com.robin.lazy.sample D/LazyLogger: ╚════════════════════════════════════════════════════════════════════════════════════════
    
 **LogLevel设置全局日志打印级别的枚举,用来过滤不需要的日志**
     /**
     	 * 输出所有类型日志
     	 */
     	ALL(0),
     
     	/**
     	 * trace类型日志
     	 */
     	TRACE(1),
     	
     	/**
     	 * debug类型日志
     	 */
     	DEBUG(2),
     
     	/**
     	 * info类型日志
     	 */
     	INFO(3),
     	
     	/**
     	 * warn类型日志
     	 */
     	WARN(4),
     	
     	/**
     	 * error类型日志
     	 */
     	ERROR(5),
     	
     	/**
     	 * fatal类型日志
     	 */
     	FATAL(6),
     
     	/**
     	 * 关闭日志输出
     	 */
     	OFF(7);
     
  **logTool日志打印器接口,可以自定义日志打印器,目前已实现的有三种:**
       **[1](AndroidLogTool.java)**
          android普通类形的日子打印器
       **[2](Log4JTool.java)**
          Log4J日志打印器,可以输入日志到本地文件,
            public Log4JTool(Level level, String dirName, String fileName)
              可以自己设置输入的文件目录及文件名,firName为文件目录,fileName文件名
       **[3](SLF4JTool.java)**
          SLF4日志打印器,可以输入日志到本地文件,
            public SLF4JTool(Level level, String dirName, String fileName)
              可以自己设置输入的文件目录及文件名,firName为文件目录,fileName文件名
      其中后面两种日志打印器会输出日志文件到本地,所以需要配置文件读写权限,负责抛错
      <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
      <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
      
      
# 初始化完，一切工作就绪后就可以直接打印日子了，如下：
     LazyLogger.i(MainActivity.this.getClass().getName(),"onCreate");
             LazyLogger.json(area_strs);
             
  
  
     
