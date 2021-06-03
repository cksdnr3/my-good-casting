const { default: axios } = require('axios');

const SERVER = 'http://localhost:8080';

// const userInfo =
//     typeof window !== `undefined`
//         ? JSON.parse(localStorage.getItem('USER'))
//         : null;

const profileList = (pageRequest) => {
    console.log(
        'service profileList pageRequest: ' + JSON.stringify(pageRequest)
    );
    return axios({
        url: `${SERVER}/profiles/list`,
        method: 'post',
        data: pageRequest,
        headers: { Authorization: 'JWT fefege..' },
    });
};

export default { profileList };
