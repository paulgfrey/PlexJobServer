package com.pf.plexapi.model.movie;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class MediaContainer
{
	@XStreamAsAttribute
	private String mediaTagPrefix;

	@XStreamAsAttribute
	private String mediaTagVersion;

	@XStreamAsAttribute
	private String librarySectionUUID;

	@XStreamAsAttribute
	private String identifier;

	@XStreamAsAttribute
	private String librarySectionTitle;

	@XStreamAsAttribute
	private String allowSync;

	@XStreamAsAttribute
	private String librarySectionID;

    private Video Video;

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

    public String getLibrarySectionUUID ()
    {
        return librarySectionUUID;
    }

    public void setLibrarySectionUUID (String librarySectionUUID)
    {
        this.librarySectionUUID = librarySectionUUID;
    }

    public String getIdentifier ()
    {
        return identifier;
    }

    public void setIdentifier (String identifier)
    {
        this.identifier = identifier;
    }

    public String getLibrarySectionTitle ()
    {
        return librarySectionTitle;
    }

    public void setLibrarySectionTitle (String librarySectionTitle)
    {
        this.librarySectionTitle = librarySectionTitle;
    }

    public String getAllowSync ()
    {
        return allowSync;
    }

    public void setAllowSync (String allowSync)
    {
        this.allowSync = allowSync;
    }

    public String getLibrarySectionID ()
    {
        return librarySectionID;
    }

    public void setLibrarySectionID (String librarySectionID)
    {
        this.librarySectionID = librarySectionID;
    }

    public Video getVideo ()
    {
        return Video;
    }

    public void setVideo (Video Video)
    {
        this.Video = Video;
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
        return "ClassPojo [mediaTagPrefix = "+mediaTagPrefix+", mediaTagVersion = "+mediaTagVersion+", librarySectionUUID = "+librarySectionUUID+", identifier = "+identifier+", librarySectionTitle = "+librarySectionTitle+", allowSync = "+allowSync+", librarySectionID = "+librarySectionID+", Video = "+Video+", size = "+size+"]";
    }
}