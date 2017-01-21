package saul.app.autotest.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmtbDictionary other = (CmtbDictionary) that;
        return (this.getCdId() == null ? other.getCdId() == null : this.getCdId().equals(other.getCdId()))
                && (this.getCdName() == null ? other.getCdName() == null : this.getCdName().equals(other.getCdName()))
                && (this.getCdType() == null ? other.getCdType() == null : this.getCdType().equals(other.getCdType()))
                && (this.getCdFIds() == null ? other.getCdFIds() == null : this.getCdFIds().equals(other.getCdFIds()))
                && (this.getCdValue() == null ? other.getCdValue() == null : this.getCdValue().equals(other.getCdValue()))
                && (this.getCdText() == null ? other.getCdText() == null : this.getCdText().equals(other.getCdText()))
                && (this.getCdStatus() == null ? other.getCdStatus() == null : this.getCdStatus().equals(other.getCdStatus()))
                && (this.getCdCreatetime() == null ? other.getCdCreatetime() == null : this.getCdCreatetime().equals(other.getCdCreatetime()))
                && (this.getCdCreateuser() == null ? other.getCdCreateuser() == null : this.getCdCreateuser().equals(other.getCdCreateuser()))
                && (this.getCdUpdatetime() == null ? other.getCdUpdatetime() == null : this.getCdUpdatetime().equals(other.getCdUpdatetime()))
                && (this.getCdUpdateuser() == null ? other.getCdUpdateuser() == null : this.getCdUpdateuser().equals(other.getCdUpdateuser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCdId() == null) ? 0 : getCdId().hashCode());
        result = prime * result + ((getCdName() == null) ? 0 : getCdName().hashCode());
        result = prime * result + ((getCdType() == null) ? 0 : getCdType().hashCode());
        result = prime * result + ((getCdFIds() == null) ? 0 : getCdFIds().hashCode());
        result = prime * result + ((getCdValue() == null) ? 0 : getCdValue().hashCode());
        result = prime * result + ((getCdText() == null) ? 0 : getCdText().hashCode());
        result = prime * result + ((getCdStatus() == null) ? 0 : getCdStatus().hashCode());
        result = prime * result + ((getCdCreatetime() == null) ? 0 : getCdCreatetime().hashCode());
        result = prime * result + ((getCdCreateuser() == null) ? 0 : getCdCreateuser().hashCode());
        result = prime * result + ((getCdUpdatetime() == null) ? 0 : getCdUpdatetime().hashCode());
        result = prime * result + ((getCdUpdateuser() == null) ? 0 : getCdUpdateuser().hashCode());
        return result;
    }
}