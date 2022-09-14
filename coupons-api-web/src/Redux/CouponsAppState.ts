import { CouponModel } from "../Models/CouponModel";


export class CouponsAppState {
    public Coupons: CouponModel[] = [];
}

export enum CouponsActionType {
    CouponsDownloaded = "CouponsDownloaded",
    CouponAdded = "CouponAdded",
    CouponUpdated = "CouponUpdated",
    CouponDeleted = "CouponDeleted",
    CouponClear = "CouponClear",
    CouponPurchased = "CouponPurchased"
}

export interface CouponAction {
    type: CouponsActionType;
    payload?: any;
}


export function CouponsDownloadedAction(Coupons: CouponModel[]): CouponAction {
    return { type: CouponsActionType.CouponsDownloaded, payload: Coupons };
}

export function CouponAddedAction(Coupon: CouponModel): CouponAction {
    return { type: CouponsActionType.CouponAdded, payload: Coupon };
}

export function CouponUpdatedAction(Coupon: CouponModel): CouponAction {
    return { type: CouponsActionType.CouponUpdated, payload: Coupon };
}

export function CouponDeletedAction(id: number): CouponAction {
    return { type: CouponsActionType.CouponDeleted, payload: id };
}

export function CouponPurchasedAction(id: number): CouponAction {
    return { type: CouponsActionType.CouponPurchased, payload: id };
}

export function CouponsClear(): CouponAction {
    return { type: CouponsActionType.CouponDeleted };
}


export function CouponsReducer(currentState: CouponsAppState = new CouponsAppState(), action: CouponAction): CouponsAppState {


    const newState = { ...currentState }

    switch (action.type) {
        case CouponsActionType.CouponsDownloaded:
            newState.Coupons = action.payload;
            break;
        case CouponsActionType.CouponAdded:
            newState.Coupons.push(action.payload);
            break;
        case CouponsActionType.CouponUpdated:
            const idx = newState.Coupons.findIndex(t => t.id === action.payload.id);
            newState.Coupons[idx] = action.payload;
            break;
        case CouponsActionType.CouponDeleted:
            newState.Coupons = newState.Coupons.filter(c => c.id !== action.payload);
            break;

        case CouponsActionType.CouponClear:
            newState.Coupons = [];
            break;
    }
    return newState;
}