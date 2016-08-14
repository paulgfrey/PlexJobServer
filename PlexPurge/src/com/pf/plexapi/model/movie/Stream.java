package com.pf.plexapi.model.movie;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Stream
{
	@XStreamAsAttribute
	private String index;

	@XStreamAsAttribute
	private String chromaSubsampling;

	@XStreamAsAttribute
	private String streamIdentifier;

	@XStreamAsAttribute
	private String width;

	@XStreamAsAttribute
	private String hasScalingMatrix;

	@XStreamAsAttribute
	private String codec;

	@XStreamAsAttribute
	private String scanType;

	@XStreamAsAttribute
	private String id;

	@XStreamAsAttribute
	private String bitDepth;

	@XStreamAsAttribute
	private String pixelFormat;

	@XStreamAsAttribute
	private String codecID;

	@XStreamAsAttribute
	private String duration;

	@XStreamAsAttribute
	private String defaultValue;

	@XStreamAsAttribute
	private String frameRateMode;

	@XStreamAsAttribute
	private String height;

	@XStreamAsAttribute
	private String level;

	@XStreamAsAttribute
	private String refFrames;

	@XStreamAsAttribute
	private String streamType;

	@XStreamAsAttribute
	private String bitrate;

	@XStreamAsAttribute
	private String frameRate;

	@XStreamAsAttribute
	private String cabac;

	@XStreamAsAttribute
	private String profile;

    public String getIndex ()
    {
        return index;
    }

    public void setIndex (String index)
    {
        this.index = index;
    }

    public String getChromaSubsampling ()
    {
        return chromaSubsampling;
    }

    public void setChromaSubsampling (String chromaSubsampling)
    {
        this.chromaSubsampling = chromaSubsampling;
    }

    public String getStreamIdentifier ()
    {
        return streamIdentifier;
    }

    public void setStreamIdentifier (String streamIdentifier)
    {
        this.streamIdentifier = streamIdentifier;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getHasScalingMatrix ()
    {
        return hasScalingMatrix;
    }

    public void setHasScalingMatrix (String hasScalingMatrix)
    {
        this.hasScalingMatrix = hasScalingMatrix;
    }

    public String getCodec ()
    {
        return codec;
    }

    public void setCodec (String codec)
    {
        this.codec = codec;
    }

    public String getScanType ()
    {
        return scanType;
    }

    public void setScanType (String scanType)
    {
        this.scanType = scanType;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBitDepth ()
    {
        return bitDepth;
    }

    public void setBitDepth (String bitDepth)
    {
        this.bitDepth = bitDepth;
    }

    public String getPixelFormat ()
    {
        return pixelFormat;
    }

    public void setPixelFormat (String pixelFormat)
    {
        this.pixelFormat = pixelFormat;
    }

    public String getCodecID ()
    {
        return codecID;
    }

    public void setCodecID (String codecID)
    {
        this.codecID = codecID;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getDefaultValue ()
    {
        return defaultValue;
    }

    public void setDefaultValue (String defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    public String getFrameRateMode ()
    {
        return frameRateMode;
    }

    public void setFrameRateMode (String frameRateMode)
    {
        this.frameRateMode = frameRateMode;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
    }

    public String getRefFrames ()
    {
        return refFrames;
    }

    public void setRefFrames (String refFrames)
    {
        this.refFrames = refFrames;
    }

    public String getStreamType ()
    {
        return streamType;
    }

    public void setStreamType (String streamType)
    {
        this.streamType = streamType;
    }

    public String getBitrate ()
    {
        return bitrate;
    }

    public void setBitrate (String bitrate)
    {
        this.bitrate = bitrate;
    }

    public String getFrameRate ()
    {
        return frameRate;
    }

    public void setFrameRate (String frameRate)
    {
        this.frameRate = frameRate;
    }

    public String getCabac ()
    {
        return cabac;
    }

    public void setCabac (String cabac)
    {
        this.cabac = cabac;
    }

    public String getProfile ()
    {
        return profile;
    }

    public void setProfile (String profile)
    {
        this.profile = profile;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [index = "+index+", chromaSubsampling = "+chromaSubsampling+", streamIdentifier = "+streamIdentifier+", width = "+width+", hasScalingMatrix = "+hasScalingMatrix+", codec = "+codec+", scanType = "+scanType+", id = "+id+", bitDepth = "+bitDepth+", pixelFormat = "+pixelFormat+", codecID = "+codecID+", duration = "+duration+", default = "+defaultValue+", frameRateMode = "+frameRateMode+", height = "+height+", level = "+level+", refFrames = "+refFrames+", streamType = "+streamType+", bitrate = "+bitrate+", frameRate = "+frameRate+", cabac = "+cabac+", profile = "+profile+"]";
    }
}