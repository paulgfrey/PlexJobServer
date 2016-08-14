package com.pf.plexapi.model.movie;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Media
{
	@XStreamAsAttribute
	private String optimizedForStreaming;

	@XStreamAsAttribute
	private String has64bitOffsets;

	@XStreamAsAttribute
	private String audioCodec;

	@XStreamAsAttribute
	private String videoResolution;

	@XStreamAsAttribute
	private String width;

	@XStreamAsAttribute
	private String videoProfile;

	@XStreamAsAttribute
	private String audioProfile;

	@XStreamAsAttribute
	private String aspectRatio;

	@XStreamAsAttribute
	private String id;

	@XStreamAsAttribute
	private String audioChannels;

	@XStreamAsAttribute
	private String duration;

	@XStreamAsAttribute
	private String videoFrameRate;

	@XStreamAsAttribute
	private String height;

	@XStreamAsAttribute
	private String container;

	@XStreamAsAttribute
	private String bitrate;

	@XStreamImplicit(itemFieldName="Part")
	private List<Part> Part;

	@XStreamAsAttribute
	private String videoCodec;

    public String getOptimizedForStreaming ()
    {
        return optimizedForStreaming;
    }

    public void setOptimizedForStreaming (String optimizedForStreaming)
    {
        this.optimizedForStreaming = optimizedForStreaming;
    }

    public String getHas64bitOffsets ()
    {
        return has64bitOffsets;
    }

    public void setHas64bitOffsets (String has64bitOffsets)
    {
        this.has64bitOffsets = has64bitOffsets;
    }

    public String getAudioCodec ()
    {
        return audioCodec;
    }

    public void setAudioCodec (String audioCodec)
    {
        this.audioCodec = audioCodec;
    }

    public String getVideoResolution ()
    {
        return videoResolution;
    }

    public void setVideoResolution (String videoResolution)
    {
        this.videoResolution = videoResolution;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
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

    public String getAspectRatio ()
    {
        return aspectRatio;
    }

    public void setAspectRatio (String aspectRatio)
    {
        this.aspectRatio = aspectRatio;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAudioChannels ()
    {
        return audioChannels;
    }

    public void setAudioChannels (String audioChannels)
    {
        this.audioChannels = audioChannels;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getVideoFrameRate ()
    {
        return videoFrameRate;
    }

    public void setVideoFrameRate (String videoFrameRate)
    {
        this.videoFrameRate = videoFrameRate;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getContainer ()
    {
        return container;
    }

    public void setContainer (String container)
    {
        this.container = container;
    }

    public String getBitrate ()
    {
        return bitrate;
    }

    public void setBitrate (String bitrate)
    {
        this.bitrate = bitrate;
    }

    public List<Part> getPart ()
    {
        return Part;
    }

    public void setPart (List<Part> Part)
    {
        this.Part = Part;
    }

    public String getVideoCodec ()
    {
        return videoCodec;
    }

    public void setVideoCodec (String videoCodec)
    {
        this.videoCodec = videoCodec;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [optimizedForStreaming = "+optimizedForStreaming+", has64bitOffsets = "+has64bitOffsets+", audioCodec = "+audioCodec+", videoResolution = "+videoResolution+", width = "+width+", videoProfile = "+videoProfile+", audioProfile = "+audioProfile+", aspectRatio = "+aspectRatio+", id = "+id+", audioChannels = "+audioChannels+", duration = "+duration+", videoFrameRate = "+videoFrameRate+", height = "+height+", container = "+container+", bitrate = "+bitrate+", Part = "+Part+", videoCodec = "+videoCodec+"]";
    }
}