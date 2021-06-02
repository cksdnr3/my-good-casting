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

export const fileRegister = createAsyncThunk(
    'FILE_REGISTER',
    async (formData) => {
        console.log('thunk enter');
        const response = await profileService.fileRegister(formData);

        return response.data;
    }
);

const profileSlice = createSlice({
    name: 'profile',
    initialState: {
        pageRequest: {
            page: 1,
            size: 10,
            type: '',
            sort: 'profileId',
            searchCond: {
                afrom: 0,
                ato: 0,
                rKeyword: '',
                gKeyword: '',
                wfrom: 0,
                wto: 0,
                hfrom: 0,
                hto: 0,
            },
            file: {
                fileName: '',
                uuid: '',
            },
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
        },
    },
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(profileList.fulfilled, (state, { payload }) => {
                console.log('payload :' + JSON.stringify(payload));

                return {
                    ...state,
                    pageResult: { ...payload },
                };
            })
            .addCase(fileRegister.fulfilled, (state, { payload }) => {
                console.log('searchResemble ' + JSON.stringify(payload));
                return {
                    ...state,
                    pageRequest: {
                        ...state.pageRequest,
                        file: { ...payload[0] },
                    },
                };
            });
    },
});
export const profileSelector = (state) => state.profileReducer;

export const {} = profileSlice.actions;
export default profileSlice.reducer;
