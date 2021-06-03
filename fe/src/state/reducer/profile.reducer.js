import profileService from '../service/profile.service';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const profileList = createAsyncThunk(
    'PROFILE_LIST',
    async (pageRequest) => {
        console.log(
            'reducer profileList() pageRequest: ' + JSON.stringify(pageRequest)
        );
        const response = await profileService.profileList(pageRequest);

        return response.data;
    }
);

const initialState = {
    pageRequest: {
        page: 1,
        size: 10,
        sort: 'profileId',
    },
    pageResult: {
        pageList: [],
        dtoList: [],
        page: 1,
        size: 10,
        totalPage: 0,
        start: 0,
        end: 0,
        prev: false,
        next: false,
        totalElement: 0,
        pageRequest: {},
    },
    reset: false,
};

const profileSlice = createSlice({
    name: 'profile',
    initialState: initialState,
    reducers: {
        resetProfileSearch: (state = initialState) => {
            return {
                ...initialState,
                reset: !state.reset,
            };
        },
    },
    extraReducers: (builder) => {
        builder.addCase(profileList.fulfilled, (state, { payload }) => {
            console.log('payload :' + JSON.stringify(payload));

            return {
                ...state,
                pageResult: payload,
                pageRequest: payload.pageRequest,
            };
        });
    },
});
export const profileSelector = (state) => state.profileReducer;

export const { resetProfileSearch } = profileSlice.actions;
export default profileSlice.reducer;
