package com.luomantic.program_view_framework.bean;

import java.util.List;

public class ConfigBean {

    /**
     * WINDOWS : {"x":0,"y":0,"w":1280,"h":800,"VERSIONINFO":{"version":"1.0.0","timeDate":"2018-03-02"},"PROGRAM":{"startDate":"2012-06-03","endDate":"2035-12-12","nConfigType":0,"nDispTimes":100,"nweekList":"0,1,2,3,4,5,6","PRGORAMNAME":"prog003","maCount":1},"MAIN_WINDOW":{"ZERO":{"x":0,"y":0,"w":1280,"h":80},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":0,"inSpeed":4,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":30,"textcolor":33023,"backcolor":12023}},{"FILE":{"filename":"/3/005.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":1,"inSpeed":2,"stayTime":0},"FONTCOLOR":{"fontname":2,"fontsize":40,"textcolor":12023,"backcolor":32145}}]}},"SUB_WINDOW":[{"ZERO":{"x":0,"y":80,"w":640,"h":420},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/003.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/004.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}},{"ZERO":{"x":640,"y":80,"w":640,"h":420},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":3,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":60,"textcolor":33023,"backcolor":32145}},{"FILE":{"filename":"/3/001.JPG","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/002.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/003.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}},{"ZERO":{"x":0,"y":500,"w":640,"h":300},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/001.JPG","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/002.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/006.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/007.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/008.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/009.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}},{"ZERO":{"x":640,"y":500,"w":640,"h":300},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":0,"inSpeed":4,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":30,"textcolor":33023,"backcolor":12023}},{"FILE":{"filename":"/3/102.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}}]}
     */

    private WINDOWSBean WINDOWS;

    public WINDOWSBean getWINDOWS() {
        return WINDOWS;
    }

    public void setWINDOWS(WINDOWSBean WINDOWS) {
        this.WINDOWS = WINDOWS;
    }

    public static class WINDOWSBean {
        /**
         * x : 0
         * y : 0
         * w : 1280
         * h : 800
         * VERSIONINFO : {"version":"1.0.0","timeDate":"2018-03-02"}
         * PROGRAM : {"startDate":"2012-06-03","endDate":"2035-12-12","nConfigType":0,"nDispTimes":100,"nweekList":"0,1,2,3,4,5,6","PRGORAMNAME":"prog003","maCount":1}
         * MAIN_WINDOW : {"ZERO":{"x":0,"y":0,"w":1280,"h":80},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":0,"inSpeed":4,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":30,"textcolor":33023,"backcolor":12023}},{"FILE":{"filename":"/3/005.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":1,"inSpeed":2,"stayTime":0},"FONTCOLOR":{"fontname":2,"fontsize":40,"textcolor":12023,"backcolor":32145}}]}}
         * SUB_WINDOW : [{"ZERO":{"x":0,"y":80,"w":640,"h":420},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/003.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/004.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}},{"ZERO":{"x":640,"y":80,"w":640,"h":420},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":3,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":60,"textcolor":33023,"backcolor":32145}},{"FILE":{"filename":"/3/001.JPG","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/002.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/003.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}},{"ZERO":{"x":0,"y":500,"w":640,"h":300},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/001.JPG","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/002.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/006.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/007.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/008.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/009.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}},{"ZERO":{"x":640,"y":500,"w":640,"h":300},"ITEMS":{"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":0,"inSpeed":4,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":30,"textcolor":33023,"backcolor":12023}},{"FILE":{"filename":"/3/102.gif","filetype":33},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":10},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}}]
         */

        private int x;
        private int y;
        private int w;
        private int h;
        private VERSIONINFOBean VERSIONINFO;
        private PROGRAMBean PROGRAM;
        private MAINWINDOWBean MAIN_WINDOW;
        private List<SUBWINDOWBean> SUB_WINDOW;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public VERSIONINFOBean getVERSIONINFO() {
            return VERSIONINFO;
        }

        public void setVERSIONINFO(VERSIONINFOBean VERSIONINFO) {
            this.VERSIONINFO = VERSIONINFO;
        }

        public PROGRAMBean getPROGRAM() {
            return PROGRAM;
        }

        public void setPROGRAM(PROGRAMBean PROGRAM) {
            this.PROGRAM = PROGRAM;
        }

        public MAINWINDOWBean getMAIN_WINDOW() {
            return MAIN_WINDOW;
        }

        public void setMAIN_WINDOW(MAINWINDOWBean MAIN_WINDOW) {
            this.MAIN_WINDOW = MAIN_WINDOW;
        }

        public List<SUBWINDOWBean> getSUB_WINDOW() {
            return SUB_WINDOW;
        }

        public void setSUB_WINDOW(List<SUBWINDOWBean> SUB_WINDOW) {
            this.SUB_WINDOW = SUB_WINDOW;
        }

        public static class VERSIONINFOBean {
            /**
             * version : 1.0.0
             * timeDate : 2018-03-02
             */

            private String version;
            private String timeDate;

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getTimeDate() {
                return timeDate;
            }

            public void setTimeDate(String timeDate) {
                this.timeDate = timeDate;
            }

            @Override
            public String toString() {
                return "VERSIONINFOBean{" +
                        "version='" + version + '\'' +
                        ", timeDate='" + timeDate + '\'' +
                        '}';
            }
        }

        public static class PROGRAMBean {
            /**
             * startDate : 2012-06-03
             * endDate : 2035-12-12
             * nConfigType : 0
             * nDispTimes : 100
             * nweekList : 0,1,2,3,4,5,6
             * PRGORAMNAME : prog003
             * maCount : 1
             */

            private String startDate;
            private String endDate;
            private int nConfigType;
            private int nDispTimes;
            private String nweekList;
            private String PRGORAMNAME;
            private int maCount;

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public int getNConfigType() {
                return nConfigType;
            }

            public void setNConfigType(int nConfigType) {
                this.nConfigType = nConfigType;
            }

            public int getNDispTimes() {
                return nDispTimes;
            }

            public void setNDispTimes(int nDispTimes) {
                this.nDispTimes = nDispTimes;
            }

            public String getNweekList() {
                return nweekList;
            }

            public void setNweekList(String nweekList) {
                this.nweekList = nweekList;
            }

            public String getPRGORAMNAME() {
                return PRGORAMNAME;
            }

            public void setPRGORAMNAME(String PRGORAMNAME) {
                this.PRGORAMNAME = PRGORAMNAME;
            }

            public int getMaCount() {
                return maCount;
            }

            public void setMaCount(int maCount) {
                this.maCount = maCount;
            }

            @Override
            public String toString() {
                return "PROGRAMBean{" +
                        "startDate='" + startDate + '\'' +
                        ", endDate='" + endDate + '\'' +
                        ", nConfigType=" + nConfigType +
                        ", nDispTimes=" + nDispTimes +
                        ", nweekList='" + nweekList + '\'' +
                        ", PRGORAMNAME='" + PRGORAMNAME + '\'' +
                        ", maCount=" + maCount +
                        '}';
            }
        }

        public static class MAINWINDOWBean {
            /**
             * ZERO : {"x":0,"y":0,"w":1280,"h":80}
             * ITEMS : {"ITEM":[{"FILE":{"filename":"/3/000.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":0,"inSpeed":4,"stayTime":0},"FONTCOLOR":{"fontname":1,"fontsize":30,"textcolor":33023,"backcolor":12023}},{"FILE":{"filename":"/3/005.txt","filetype":68},"SHOWFORMAT":{"showtype":0,"InType":1,"inSpeed":2,"stayTime":0},"FONTCOLOR":{"fontname":2,"fontsize":40,"textcolor":12023,"backcolor":32145}}]}
             */

            private ZEROBean ZERO;
            private ITEMSBean ITEMS;

            public ZEROBean getZERO() {
                return ZERO;
            }

            public void setZERO(ZEROBean ZERO) {
                this.ZERO = ZERO;
            }

            public ITEMSBean getITEMS() {
                return ITEMS;
            }

            public void setITEMS(ITEMSBean ITEMS) {
                this.ITEMS = ITEMS;
            }

            public static class ZEROBean {
                /**
                 * x : 0
                 * y : 0
                 * w : 1280
                 * h : 80
                 */

                private int x;
                private int y;
                private int w;
                private int h;

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getW() {
                    return w;
                }

                public void setW(int w) {
                    this.w = w;
                }

                public int getH() {
                    return h;
                }

                public void setH(int h) {
                    this.h = h;
                }

                @Override
                public String toString() {
                    return "ZEROBean{" +
                            "x=" + x +
                            ", y=" + y +
                            ", w=" + w +
                            ", h=" + h +
                            '}';
                }
            }

            public static class ITEMSBean {
                private List<ITEMBean> ITEM;

                public List<ITEMBean> getITEM() {
                    return ITEM;
                }

                public void setITEM(List<ITEMBean> ITEM) {
                    this.ITEM = ITEM;
                }

                public static class ITEMBean {
                    /**
                     * FILE : {"filename":"/3/000.txt","filetype":68}
                     * SHOWFORMAT : {"showtype":0,"InType":0,"inSpeed":4,"stayTime":0}
                     * FONTCOLOR : {"fontname":1,"fontsize":30,"textcolor":33023,"backcolor":12023}
                     */

                    private FILEBean FILE;
                    private SHOWFORMATBean SHOWFORMAT;
                    private FONTCOLORBean FONTCOLOR;

                    public FILEBean getFILE() {
                        return FILE;
                    }

                    public void setFILE(FILEBean FILE) {
                        this.FILE = FILE;
                    }

                    public SHOWFORMATBean getSHOWFORMAT() {
                        return SHOWFORMAT;
                    }

                    public void setSHOWFORMAT(SHOWFORMATBean SHOWFORMAT) {
                        this.SHOWFORMAT = SHOWFORMAT;
                    }

                    public FONTCOLORBean getFONTCOLOR() {
                        return FONTCOLOR;
                    }

                    public void setFONTCOLOR(FONTCOLORBean FONTCOLOR) {
                        this.FONTCOLOR = FONTCOLOR;
                    }

                    public static class FILEBean {
                        /**
                         * filename : /3/000.txt
                         * filetype : 68
                         */

                        private String filename;
                        private int filetype;

                        public String getFilename() {
                            return filename;
                        }

                        public void setFilename(String filename) {
                            this.filename = filename;
                        }

                        public int getFiletype() {
                            return filetype;
                        }

                        public void setFiletype(int filetype) {
                            this.filetype = filetype;
                        }

                        @Override
                        public String toString() {
                            return "FILEBean{" +
                                    "filename='" + filename + '\'' +
                                    ", filetype=" + filetype +
                                    '}';
                        }
                    }

                    public static class SHOWFORMATBean {
                        /**
                         * showtype : 0
                         * InType : 0
                         * inSpeed : 4
                         * stayTime : 0
                         */

                        private int showtype;
                        private int InType;
                        private int inSpeed;
                        private int stayTime;

                        public int getShowtype() {
                            return showtype;
                        }

                        public void setShowtype(int showtype) {
                            this.showtype = showtype;
                        }

                        public int getInType() {
                            return InType;
                        }

                        public void setInType(int InType) {
                            this.InType = InType;
                        }

                        public int getInSpeed() {
                            return inSpeed;
                        }

                        public void setInSpeed(int inSpeed) {
                            this.inSpeed = inSpeed;
                        }

                        public int getStayTime() {
                            return stayTime;
                        }

                        public void setStayTime(int stayTime) {
                            this.stayTime = stayTime;
                        }

                        @Override
                        public String toString() {
                            return "SHOWFORMATBean{" +
                                    "showtype=" + showtype +
                                    ", InType=" + InType +
                                    ", inSpeed=" + inSpeed +
                                    ", stayTime=" + stayTime +
                                    '}';
                        }
                    }

                    public static class FONTCOLORBean {
                        /**
                         * fontname : 1
                         * fontsize : 30
                         * textcolor : 33023
                         * backcolor : 12023
                         */

                        private int fontname;
                        private int fontsize;
                        private int textcolor;
                        private int backcolor;

                        public int getFontname() {
                            return fontname;
                        }

                        public void setFontname(int fontname) {
                            this.fontname = fontname;
                        }

                        public int getFontsize() {
                            return fontsize;
                        }

                        public void setFontsize(int fontsize) {
                            this.fontsize = fontsize;
                        }

                        public int getTextcolor() {
                            return textcolor;
                        }

                        public void setTextcolor(int textcolor) {
                            this.textcolor = textcolor;
                        }

                        public int getBackcolor() {
                            return backcolor;
                        }

                        public void setBackcolor(int backcolor) {
                            this.backcolor = backcolor;
                        }

                        @Override
                        public String toString() {
                            return "FONTCOLORBean{" +
                                    "fontname=" + fontname +
                                    ", fontsize=" + fontsize +
                                    ", textcolor=" + textcolor +
                                    ", backcolor=" + backcolor +
                                    '}';
                        }
                    }

                    @Override
                    public String toString() {
                        return "ITEMBean{" +
                                "FILE=" + FILE +
                                ", SHOWFORMAT=" + SHOWFORMAT +
                                ", FONTCOLOR=" + FONTCOLOR +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "ITEMSBean{" +
                            "ITEM=" + ITEM +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "MAINWINDOWBean{" +
                        "ZERO=" + ZERO +
                        ", ITEMS=" + ITEMS +
                        '}';
            }
        }

        public static class SUBWINDOWBean {
            /**
             * ZERO : {"x":0,"y":80,"w":640,"h":420}
             * ITEMS : {"ITEM":[{"FILE":{"filename":"/3/003.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}},{"FILE":{"filename":"/3/004.mp4","filetype":48},"SHOWFORMAT":{"showtype":0,"InType":2,"inSpeed":16,"stayTime":0},"FONTCOLOR":{"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}}]}
             */

            private ZEROBeanX ZERO;
            private ITEMSBeanX ITEMS;

            public ZEROBeanX getZERO() {
                return ZERO;
            }

            public void setZERO(ZEROBeanX ZERO) {
                this.ZERO = ZERO;
            }

            public ITEMSBeanX getITEMS() {
                return ITEMS;
            }

            public void setITEMS(ITEMSBeanX ITEMS) {
                this.ITEMS = ITEMS;
            }

            public static class ZEROBeanX {
                /**
                 * x : 0
                 * y : 80
                 * w : 640
                 * h : 420
                 */

                private int x;
                private int y;
                private int w;
                private int h;

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getW() {
                    return w;
                }

                public void setW(int w) {
                    this.w = w;
                }

                public int getH() {
                    return h;
                }

                public void setH(int h) {
                    this.h = h;
                }

                @Override
                public String toString() {
                    return "ZEROBeanX{" +
                            "x=" + x +
                            ", y=" + y +
                            ", w=" + w +
                            ", h=" + h +
                            '}';
                }
            }

            public static class ITEMSBeanX {
                private List<ITEMBeanX> ITEM;

                public List<ITEMBeanX> getITEM() {
                    return ITEM;
                }

                public void setITEM(List<ITEMBeanX> ITEM) {
                    this.ITEM = ITEM;
                }

                public static class ITEMBeanX {
                    /**
                     * FILE : {"filename":"/3/003.mp4","filetype":48}
                     * SHOWFORMAT : {"showtype":0,"InType":2,"inSpeed":16,"stayTime":0}
                     * FONTCOLOR : {"fontname":"","fontsize":0,"textcolor":0,"backcolor":0}
                     */

                    private FILEBeanX FILE;
                    private SHOWFORMATBeanX SHOWFORMAT;
                    private FONTCOLORBeanX FONTCOLOR;

                    public FILEBeanX getFILE() {
                        return FILE;
                    }

                    public void setFILE(FILEBeanX FILE) {
                        this.FILE = FILE;
                    }

                    public SHOWFORMATBeanX getSHOWFORMAT() {
                        return SHOWFORMAT;
                    }

                    public void setSHOWFORMAT(SHOWFORMATBeanX SHOWFORMAT) {
                        this.SHOWFORMAT = SHOWFORMAT;
                    }

                    public FONTCOLORBeanX getFONTCOLOR() {
                        return FONTCOLOR;
                    }

                    public void setFONTCOLOR(FONTCOLORBeanX FONTCOLOR) {
                        this.FONTCOLOR = FONTCOLOR;
                    }

                    public static class FILEBeanX {
                        /**
                         * filename : /3/003.mp4
                         * filetype : 48
                         */

                        private String filename;
                        private int filetype;

                        public String getFilename() {
                            return filename;
                        }

                        public void setFilename(String filename) {
                            this.filename = filename;
                        }

                        public int getFiletype() {
                            return filetype;
                        }

                        public void setFiletype(int filetype) {
                            this.filetype = filetype;
                        }

                        @Override
                        public String toString() {
                            return "FILEBeanX{" +
                                    "filename='" + filename + '\'' +
                                    ", filetype=" + filetype +
                                    '}';
                        }
                    }

                    public static class SHOWFORMATBeanX {
                        /**
                         * showtype : 0
                         * InType : 2
                         * inSpeed : 16
                         * stayTime : 0
                         */

                        private int showtype;
                        private int InType;
                        private int inSpeed;
                        private int stayTime;

                        public int getShowtype() {
                            return showtype;
                        }

                        public void setShowtype(int showtype) {
                            this.showtype = showtype;
                        }

                        public int getInType() {
                            return InType;
                        }

                        public void setInType(int InType) {
                            this.InType = InType;
                        }

                        public int getInSpeed() {
                            return inSpeed;
                        }

                        public void setInSpeed(int inSpeed) {
                            this.inSpeed = inSpeed;
                        }

                        public int getStayTime() {
                            return stayTime;
                        }

                        public void setStayTime(int stayTime) {
                            this.stayTime = stayTime;
                        }

                        @Override
                        public String toString() {
                            return "SHOWFORMATBeanX{" +
                                    "showtype=" + showtype +
                                    ", InType=" + InType +
                                    ", inSpeed=" + inSpeed +
                                    ", stayTime=" + stayTime +
                                    '}';
                        }
                    }

                    public static class FONTCOLORBeanX {
                        /**
                         * fontname :
                         * fontsize : 0
                         * textcolor : 0
                         * backcolor : 0
                         */

                        private String fontname;
                        private int fontsize;
                        private int textcolor;
                        private int backcolor;

                        public String getFontname() {
                            return fontname;
                        }

                        public void setFontname(String fontname) {
                            this.fontname = fontname;
                        }

                        public int getFontsize() {
                            return fontsize;
                        }

                        public void setFontsize(int fontsize) {
                            this.fontsize = fontsize;
                        }

                        public int getTextcolor() {
                            return textcolor;
                        }

                        public void setTextcolor(int textcolor) {
                            this.textcolor = textcolor;
                        }

                        public int getBackcolor() {
                            return backcolor;
                        }

                        public void setBackcolor(int backcolor) {
                            this.backcolor = backcolor;
                        }

                        @Override
                        public String toString() {
                            return "FONTCOLORBeanX{" +
                                    "fontname='" + fontname + '\'' +
                                    ", fontsize=" + fontsize +
                                    ", textcolor=" + textcolor +
                                    ", backcolor=" + backcolor +
                                    '}';
                        }
                    }

                    @Override
                    public String toString() {
                        return "ITEMBeanX{" +
                                "FILE=" + FILE +
                                ", SHOWFORMAT=" + SHOWFORMAT +
                                ", FONTCOLOR=" + FONTCOLOR +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "ITEMSBeanX{" +
                            "ITEM=" + ITEM +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "SUBWINDOWBean{" +
                        "ZERO=" + ZERO +
                        ", ITEMS=" + ITEMS +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "WINDOWSBean{" +
                    "x=" + x +
                    ", y=" + y +
                    ", w=" + w +
                    ", h=" + h +
                    ", VERSIONINFO=" + VERSIONINFO +
                    ", PROGRAM=" + PROGRAM +
                    ", MAIN_WINDOW=" + MAIN_WINDOW +
                    ", SUB_WINDOW=" + SUB_WINDOW +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "WINDOWS=" + WINDOWS +
                '}';
    }
}
