const api = (url, opts = {}) =>
    fetch(url, opts).then(r => {
        if (!r.ok) throw new Error("api error");
        return r.json();
    });
