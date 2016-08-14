package com.pf.plexapi.model.movie;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Field
{
    @XStreamAsAttribute
	private String name;

    @XStreamAsAttribute
    private String locked;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLocked ()
    {
        return locked;
    }

    public void setLocked (String locked)
    {
        this.locked = locked;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", locked = "+locked+"]";
    }
}