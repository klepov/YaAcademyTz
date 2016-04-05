
package klep.yaacademytz.model;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
@Generated("org.jsonschema2pojo")
public class Cover implements Parcelable {

    @SerializedName("small")
    @Expose
    public String small;
    @SerializedName("big")
    @Expose
    public String big;

    /**
     * 
     * @return
     *     The small
     */
    public String getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    public void setSmall(String small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The big
     */
    public String getBig() {
        return big;
    }

    /**
     * 
     * @param big
     *     The big
     */
    public void setBig(String big) {
        this.big = big;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        CoverParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<Cover> CREATOR = new Creator<Cover>() {
        public Cover createFromParcel(Parcel source) {
            Cover target = new Cover();
            CoverParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public Cover[] newArray(int size) {
            return new Cover[size];
        }
    };
}
