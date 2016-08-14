package com.pf.plexapi.model.library;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


public class MediaContainer
{
	@XStreamAsAttribute
	private String mediaTagPrefix;

	@XStreamAsAttribute
	private String mediaTagVersion;

	@XStreamAsAttribute
	private String title1;

	@XStreamAsAttribute
	private String identifier;

	@XStreamAsAttribute
	private String allowSync;

	@XStreamImplicit
    private Directory[] Directory;

	@XStreamAsAttribute
	private String size;

    public String getMediaTagPrefix ()
    {
        return mediaTagPrefix;
    }

    public void setMediaTagPrefix (String mediaTagPrefix)
    {
        this.mediaTagPrefix = mediaTagPrefix;
    }

    public String getMediaTagVersion ()
    {
        return mediaTagVersion;
    }

    public void setMediaTagVersion (String mediaTagVersion)
    {
        this.mediaTagVersion = mediaTagVersion;
    }

    public String getTitle1 ()
    {
        return title1;
    }

    public void setTitle1 (String title1)
    {
        this.title1 = title1;
    }

    public String getIdentifier ()
    {
        return identifier;
    }

    public void setIdentifier (String identifier)
    {
        this.identifier = identifier;
    }

    public String getAllowSync ()
    {
        return allowSync;
    }

    public void setAllowSync (String allowSync)
    {
        this.allowSync = allowSync;
    }

    public Directory[] getDirectory ()
    {
        return Directory;
    }

    public void setDirectory (Directory[] Directory)
    {
        this.Directory = Directory;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mediaTagPrefix = "+mediaTagPrefix+", mediaTagVersion = "+mediaTagVersion+", title1 = "+title1+", identifier = "+identifier+", allowSync = "+allowSync+", Directory = "+Directory+", size = "+size+"]";
    }
}