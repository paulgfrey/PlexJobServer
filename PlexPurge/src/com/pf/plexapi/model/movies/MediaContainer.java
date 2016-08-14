package com.pf.plexapi.model.movies;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class MediaContainer
{
	@XStreamAsAttribute
	private String title1;

	@XStreamAsAttribute
	private String viewGroup;

	@XStreamAsAttribute
	private String librarySectionUUID;

	@XStreamAsAttribute
	private String art;

	@XStreamAsAttribute
	private String title2;

	@XStreamAsAttribute
	private String librarySectionTitle;

	@XStreamAsAttribute
	private String allowSync;

	@XStreamAsAttribute
	private String librarySectionID;

	@XStreamAsAttribute
	private String size;

	@XStreamAsAttribute
	private String mediaTagPrefix;

	@XStreamAsAttribute
	private String mediaTagVersion;

	@XStreamAsAttribute
	private String viewMode;

	@XStreamAsAttribute
	private String thumb;

	@XStreamAsAttribute
	private String identifier;

	@XStreamImplicit
	private Video[] video;

    public String getTitle1 ()
    {
        return title1;
    }

    public void setTitle1 (String title1)
    {
        this.title1 = title1;
    }

    public String getViewGroup ()
    {
        return viewGroup;
    }

    public void setViewGroup (String viewGroup)
    {
        this.viewGroup = viewGroup;
    }

    public String getLibrarySectionUUID ()
    {
        return librarySectionUUID;
    }

    public void setLibrarySectionUUID (String librarySectionUUID)
    {
        this.librarySectionUUID = librarySectionUUID;
    }

    public String getArt ()
    {
        return art;
    }

    public void setArt (String art)
    {
        this.art = art;
    }

    public String getTitle2 ()
    {
        return title2;
    }

    public void setTitle2 (String title2)
    {
        this.title2 = title2;
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

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

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

    public String getViewMode ()
    {
        return viewMode;
    }

    public void setViewMode (String viewMode)
    {
        this.viewMode = viewMode;
    }

    public String getThumb ()
    {
        return thumb;
    }

    public void setThumb (String thumb)
    {
        this.thumb = thumb;
    }

    public String getIdentifier ()
    {
        return identifier;
    }

    public void setIdentifier (String identifier)
    {
        this.identifier = identifier;
    }

    public Video[] getVideo ()
    {
        return video;
    }

    public void setVideo (Video[] Video)
    {
        this.video = Video;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title1 = "+title1+", viewGroup = "+viewGroup+", librarySectionUUID = "+librarySectionUUID+", art = "+art+", title2 = "+title2+", librarySectionTitle = "+librarySectionTitle+", allowSync = "+allowSync+", librarySectionID = "+librarySectionID+", size = "+size+", mediaTagPrefix = "+mediaTagPrefix+", mediaTagVersion = "+mediaTagVersion+", viewMode = "+viewMode+", thumb = "+thumb+", identifier = "+identifier+", Video = "+video+"]";
    }
}