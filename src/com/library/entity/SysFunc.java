package com.library.entity;

public class SysFunc
{
    private int aiid;

    private String funckey;

    private String funcname;

    private String functype;

    private String url;

    private String css;

    private int parentid;

    private String description;

    private byte state;

    public int getAiid()
    {
        return aiid;
    }

    public void setAiid(int aiid)
    {
        this.aiid = aiid;
    }

    public String getFunckey()
    {
        return funckey;
    }

    public void setFunckey(String funckey)
    {
        this.funckey = funckey;
    }

    public String getFuncname()
    {
        return funcname;
    }

    public void setFuncname(String funcname)
    {
        this.funcname = funcname;
    }

    public String getFunctype()
    {
        return functype;
    }

    public void setFunctype(String functype)
    {
        this.functype = functype;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getCss()
    {
        return css;
    }

    public void setCss(String css)
    {
        this.css = css;
    }

    public int getParentid()
    {
        return parentid;
    }

    public void setParentid(int parentid)
    {
        this.parentid = parentid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public byte getState()
    {
        return state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return "SysFunc [aiid=" + aiid + ", funckey=" + funckey + ", funcname=" + funcname + ", functype=" + functype
                + ", url=" + url + ", css=" + css + ", parentid=" + parentid + ", description=" + description
                + ", state=" + state + "]";
    }

}
