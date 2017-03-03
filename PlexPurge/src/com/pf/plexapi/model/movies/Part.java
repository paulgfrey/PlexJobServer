package com.pf.plexapi.model.movies;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Part
{
	@XStreamAsAttribute
	private String id;

	@XStreamAsAttribute
	private String optimizedForStreaming;

	@XStreamAsAttribute
	private String duration;

	@XStreamAsAttribute
	private String has64bitOffsets;

	@XStreamAsAttribute
	private String file;

	@XStreamAsAttribute
	private String container;

	@XStreamAsAttribute
	private String videoProfile;

	@XStreamAsAttribute
	private String audioProfile;

	@XStreamAsAttribute
	private String key;

	@XStreamAsAttribute
	private String size;
	
	@XStreamOmitField
	private Object Stream;
	
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getOptimizedForStreaming ()
    {
        return optimizedForStreaming;
    }

    public void setOptimizedForStreaming (String optimizedForStreaming)
    {
        this.optimizedForStreaming = optimizedForStreaming;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getHas64bitOffsets ()
    {
        return has64bitOffsets;
    }

    public void setHas64bitOffsets (String has64bitOffsets)
    {
        this.has64bitOffsets = has64bitOffsets;
    }

    public String getFile ()
    {
        return file;
    }

    public void setFile (String file)
    {
        this.file = file;
    }

    public String getContainer ()
    {
        return container;
    }

    public void setContainer (String container)
    {
        this.container = container;
    }

    public String getVideoProfile ()
    {
        return videoProfile;
    }

    public void setVideoProfile (String videoProfile)
    {
        this.videoProfile = videoProfile;
    }

    public String getAudioProfile ()
    {
        return audioProfile;
    }

    public void setAudioProfile (String audioProfile)
    {
        this.audioProfile = audioProfile;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
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
        return "ClassPojo [id = "+id+", optimizedForStreaming = "+optimizedForStreaming+", duration = "+duration+", has64bitOffsets = "+has64bitOffsets+", file = "+file+", container = "+container+", videoProfile = "+videoProfile+", audioProfile = "+audioProfile+", key = "+key+", size = "+size+"]";
    }
}