import { Notyf } from 'notyf'

export enum SccMsg {
    ALL_COUPONS = 'got all coupons successfully',
    SINGLE_COUPONS = 'got single coupons successfully',
    DELETE_COUPONS = 'deleted coupons successfully',
    Purchase_COUPONS = 'purchased coupons successfully',
    UPDATE_COUPONS = 'updated coupons successfully',
    ADD_COUPONS = 'added coupons successfully',
    LOGIN_SUCCESS = 'login successfully',
    TOTAL_COUPONS = "total ",
    REGISTER_SUCCESS ='register successfully'
}

export enum ErrMsg {
    ALL_COUPONS = 'got all coupons successfully',
    SINGLE_COUPONS = 'got single coupons successfully',
    DELETE_COUPONS = 'deleted coupons successfully',
    Purchase_COUPONS = 'purchased coupons successfully',
    UPDATE_COUPONS = 'updated coupons successfully',
    ADD_COUPONS = 'added coupons successfully',
    LOGIN_SUCCESS = 'login successfully',
    TOTAL_COUPONS = "total ",
    REGISTER_SUCCESS ='register successfully'
}

class Notify {

    private notification = new Notyf({ duration: 4000, position: { x: "left", y: "top" } });

    public successStr(message: String) {
        this.notification.success(message as any);
    }

    public success(message: SccMsg) {
        this.notification.success(message);
    }

    public error(message: string) {
        this.notification.error(this.extractMsg(message));
    }

    private extractMsg(err: any): string {

        if (typeof err === 'string') {
            return err;
        }

        if (typeof err?.response?.data === 'string') { //Backend exact error
            return err.response.data;
        }

        if (Array.isArray(err?.response?.data)) { // Backend exact error list
            return err?.response?.data[0];
        }


        // Must be last
        if (typeof err?.message === 'string') {
            return err.message;
        }


        return "an error occurred, please try again.";


    }
}


const notify = new Notify();
export default notify;