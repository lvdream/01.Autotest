package saul.app.autotest.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CmtbDictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cdId;
    private String cdName;
    private String cdType;
    private String cdFIds;
    private String cdValue;
    private String cdText;
    private String cdStatus;
    private String cdCreatetime;
    private String cdCreateuser;
    private String cdUpdatetime;
    private String cdUpdateuser;


}