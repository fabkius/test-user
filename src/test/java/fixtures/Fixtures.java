package fixtures;

import com.nissum.user.domain.PhonesDto;
import com.nissum.user.domain.UserDto;
import com.nissum.user.domain.UserRsDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fixtures {

    public static UserDto SAVE_OK(){
        UserDto dd = new UserDto();

        dd.setCreated(new Date(34234324));
        dd.setEmail("mail@mail.com");
        dd.setLast_login(new Date(34234324));
        dd.setName("name");
        dd.setPassword("Awertte1");
        dd.setModified(new Date(34234324));
        dd.setPhones(CREA_PHONES_OK());

        return dd;
    }

    public static UserDto SAVE_BADMAIL(){
        UserDto dd = new UserDto();

        dd.setCreated(new Date(34234324));
        dd.setEmail("mailmail.com");
        dd.setLast_login(new Date(34234324));
        dd.setName("name");
        dd.setPassword("Awertte1");
        dd.setModified(new Date(34234324));
        dd.setPhones(CREA_PHONES_OK());

        return dd;
    }

    public static UserDto SAVE_BADPASSWORD(){
        UserDto dd = new UserDto();

        dd.setCreated(new Date(34234324));
        dd.setEmail("mailmail.com");
        dd.setLast_login(new Date(34234324));
        dd.setName("name");
        dd.setPassword("Awertt3333e1");
        dd.setModified(new Date(34234324));
        dd.setPhones(CREA_PHONES_OK());

        return dd;
    }

    private static List<PhonesDto> CREA_PHONES_OK() {
        List<PhonesDto> phones = new ArrayList<>();
        PhonesDto phone = new PhonesDto();

        phone.setCitycode("32");
        phone.setContrycode("cl");
        phone.setNumber("2423543534");

        phones.add(phone);

        return phones;
    }

    public static UserRsDto SAVE_RS_OK() {
        UserRsDto dd = new UserRsDto();
        dd.setId(1l);
        dd.setCreated("11-01-2020 11:22:11");
        dd.setIsactive(true);
        dd.setToken("Bearer: dsfsfrgsfadgsdffgfgdfg");
        dd.setLast_login("11-01-2020 11:22:11");
        dd.setModified("11-01-2020 11:22:11");
        return dd;
    }

    public static Serializable CREA_RS_SAVE_SERIALIZABLE() {
        return (Long)1l;
    }

}
